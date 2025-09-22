//Project 3
//By Tyler Hoffman
//CSCI 1913

public class Gibberisher{
    private final Trie<CharBag> model;
    private final int segmentSize;
    private int letterSampleCount;

    /**
     * Constructs a Gibberisher with the given segment size.
     * @param segTracker
     */
    public Gibberisher(int segmentSize){
        this.segmentSize = segmentSize;
        this.model = new Trie<>();
        this.letterSampleCount = 0;
    }

    /**
     * Trains the model on an array of words. Each word is split into LetterSamples and updates the letter counts for each segement.
     * @param words
     */
    public void train(String[] words){
        for(String word : words){
            LetterSample[] samples = LetterSample.toSamples(word, segmentSize);
            for(LetterSample sample : samples){
                String segment = sample.getSegment();
                char next = sample.getNextLetter();
                CharBag bag = model.get(segment);
                if(bag == null){
                    bag = new CharBag();
                }
                
                bag.add(next);
                model.put(segment, bag);
                letterSampleCount++;
            }
        }
    }

    /**
     * Returns the number of LetterSamples so far.
     */
    public int getSampleCount(){
        return letterSampleCount;
    }

    /**
     * Generates a random word based on the trained model. Continues to sample the next letter until STOP.
     * @return
     */
    public String generate(){
        StringBuilder sb = new StringBuilder();
        while(true){
            int start = Math.max(0, sb.length() - segmentSize);
            String segment = sb.substring(start);
            CharBag bag = model.get(segment);
            if(bag == null){
                bag = new CharBag();
            }

            char next = bag.getRandomChar();
            if(next == LetterSample.STOP){
                break;
            }

            sb.append(next);
        }

        return sb.toString();
    }


}