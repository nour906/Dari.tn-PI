package com.example.newD.Config;


import java.util.Properties;

//please don't touch it XD
public class OpenNLP {
    /*
     public static void main(String[] args) {

        try {
            // read the training data
            InputStreamFactory dataIn = new MarkableFileInputStreamFactory(new File("C:\\Users\\karim\\Desktop\\trainingandtestdata\\train_text.txt"));
            ObjectStream lineStream = new PlainTextByLineStream(dataIn, "UTF-8");
            ObjectStream sampleStream = new DocumentSampleStream(lineStream);

            // define the training parameters
            TrainingParameters params = new TrainingParameters();
            params.put(TrainingParameters.ITERATIONS_PARAM, 1000+"");
            params.put(TrainingParameters.CUTOFF_PARAM, 0+"");
            params.put(AbstractTrainer.ALGORITHM_PARAM, NaiveBayesTrainer.NAIVE_BAYES_VALUE);
            params.put(TrainingParameters.TRAINER_TYPE_PARAM,true);

            // create a model from traning data
            DoccatModel model = DocumentCategorizerME.train("en", sampleStream, params, new DoccatFactory());
            System.out.println("\nModel is successfully trained.");

            // save the model to local
            BufferedOutputStream modelOut = new BufferedOutputStream(new FileOutputStream("C:\\Users\\karim\\Desktop\\trainingandtestdata\\classifier-naive-bayes.bin"));
            model.serialize(modelOut);
            System.out.println("\nTrained Model is saved locally at : "+"model"+File.separator+"en-movie-classifier-naive-bayes.bin");

            // test the model file by subjecting it to prediction
            DocumentCategorizer doccat = new DocumentCategorizerME(model);
            String[] docWords = "Afterwards Stuart and Charlie notice Kate in the photos Stuart took at Leopolds ball and realise that her destiny must be to go back and be with Leopold That night while Kate is accepting her promotion at a company banquet he and Charlie race to meet her and show her the pictures Kate initially rejects their overtures and goes on to give her acceptance speech but it is there that she sees Stuarts picture and realises that she truly wants to be with Leopold".replaceAll("[^A-Za-z]", " ").split(" ");
            double[] aProbs = doccat.categorize(docWords);

            // print the probabilities of the categories
            System.out.println("\n---------------------------------\nCategory : Probability\n---------------------------------");
            for(int i=0;i<doccat.getNumberOfCategories();i++){
                System.out.println(doccat.getCategory(i)+" : "+aProbs[i]);
            }
            System.out.println("---------------------------------");

            System.out.println("\n"+doccat.getBestCategory(aProbs)+" : is the predicted category for the given sentence.");
        }
        catch (IOException e) {
            System.out.println("An exception in reading the training file. Please check.");
            e.printStackTrace();
        }
    }


    private static String[] getTokens(String sentence) {



        SimpleTokenizer tokenizer = SimpleTokenizer.INSTANCE;




            return tokenizer.tokenize(sentence);


    }




    public Priority priority(String claim){


        try{
            BufferedInputStream modelin=new BufferedInputStream(
                    new FileInputStream("C:\\Users\\karim\\Desktop\\trainingandtestdata\\classifier-naive-bayes.bin"));
            DocumentCategorizerME classificationME = new DocumentCategorizerME( new DoccatModel( modelin));
            String[] documentContent = getTokens(claim);
            double[] classDistribution = classificationME .categorize(documentContent);
            String predictedCategory = classificationME .getBestCategory(classDistribution);
            System.out.println("Model prediction : " + predictedCategory);

            if(predictedCategory.equals("negative")){
                return Priority.high;
            }else if(predictedCategory.equals("normal")){
                return Priority.normal;
            }else {
                return Priority.high;
            }
        }catch (IOException e){
            System.out.println("exception");
            return Priority.normal;
        }


    }*/




}
