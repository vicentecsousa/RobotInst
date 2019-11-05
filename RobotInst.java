import java.util.Random;

public class RobotInst {

    private static Random random = new Random();
    private static int N_SAMPLES = 4;
    



    public static void main(String[] args) {
        
        String samples = generateSamples(N_SAMPLES);

        System.out.println(samples);

        String[] samplesArr = samples.split("\n");

        int ind = 1;
        for (int i = 1; i <= Integer.parseInt(samplesArr[0]); i++ ) {
            int sampleSize = Integer.parseInt(samplesArr[ind]);

            int pos = 0;
            for (int j = 1; j <= sampleSize; j++) {
                String exp = samplesArr[ ind + j ];
                while ( exp.contains("SAME") ) {
                    exp = samplesArr[ ind + Character.getNumericValue( exp.charAt( exp.length() - 1 ) ) ];
                }
                pos += exp.equals("LEFT") ? -1 : 1;
            }
            ind += sampleSize + 2;
            System.out.println("Sample " + i + " final position: " + pos);
        }


    }


    private static String generateSamples( int nSpamples ) {
        StringBuilder sb = new StringBuilder( nSpamples + "\n" );

        for (int i = 0; i < nSpamples; i++) {
            int sampleSize = random.nextInt(100) + 1;
            sb.append(generateSample(sampleSize));
        }

        return sb.toString();
    }

    private static String generateSample( int sampleSize ) {
        StringBuilder sb = new StringBuilder( sampleSize + "\n");
        for (int i = 0; i < sampleSize; i++) {
            // second random.nextInt goes up to 4 to increase the chance of SAME AS
            int rnd = i == 0 ? random.nextInt(2) : random.nextInt(5);
            if ( rnd == 0 ) {
                sb.append("LEFT\n");
            } else if ( rnd == 1) {
                sb.append("RIGHT\n");
            } else {
                sb.append("SAME AS " + (random.nextInt(i) + 1) + "\n");
            }
        }
        sb.append("-------------------------------------------------------------------------------------------\n");
        return sb.toString();
    }

}