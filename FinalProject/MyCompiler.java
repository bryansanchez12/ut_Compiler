package pp.FinalProject;

import org.antlr.v4.runtime.tree.ParseTree;
import pp.FinalProject.exceptions.ParsingError;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class MyCompiler {
    /**
     * @invariant grammarChecker not null
     */
    private GrammarChecker grammarChecker;

    private GrammarGenerator grammarGenerator;

    private ParseTree tree;

    private String ext = ".flbs";

    private String filePath;

    private String fileName;

    private File compiledHS;

    public MyCompiler (String fileName){
        String structure = "\\pp\\FinalProject\\Test-Files\\";  // TODO change this directory
        String root      = System.getProperty("user.dir");
        this.filePath    = root + structure;
        this.fileName    = fileName;
        grammarChecker   = new GrammarChecker();
        grammarGenerator = new GrammarGenerator();
    }

    /**
     * Runs the jUnit tests from this compiler according to the implemented language
     */
    private void runjUnitTests(){



    }

    /**
     * Check possible mistakes in file
     * @requires filePath!= null
     * @requires a valid filePath
     * @return true if no mistakes, false otherwise
     */
    public boolean checkGrammar() throws ParsingError {
        boolean check   = false;
        String fullPath = this.filePath + this.fileName + ext;
        Set<String> possibleMistakes = grammarChecker.check(fullPath);
        if (possibleMistakes.size() == 0){
            check = true;
            tree = grammarChecker.getTree();
        }else{
            String parsing = "The possible Mistakes are: \n";
            Iterator<String> present = possibleMistakes.iterator();
            while (present.hasNext()){
                parsing += ( present + "\n");

            }

            throw new ParsingError(parsing);
        }
        return check;
    }

    /**
     * Check whether a Haskell Script has been created
     * @requires fileName!= null
     * @return true if file created, false otherwise
     */
    public boolean createHSFile(){
        boolean check = false;
        String structure = "\\pp\\FinalProject\\Test-Files\\";  // TODO change this directory
        try {
            check = checkGrammar();
            if (check && tree != null) {
                compiledHS = grammarGenerator.generate(tree, this.fileName);
            } else {
                // throw exception
                System.out.println("Something went wrong :C");
                System.out.println("-------\t\tStatus\t\t------");
                System.out.println("check flag: " + check);
                System.out.println("tree flag:  " + (tree!=null));
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            // Something went wrong :c
            // handle that exception
        }
        return check;
    }

    public void runHSFile(){
        if (createHSFile()){

            Process mProcess;
            try{
                // run ghci from the terminal
                mProcess = Runtime.getRuntime().exec(new String[]{ "ghci"});

                InputStream stdin  = mProcess.getInputStream();
                OutputStream stout =  mProcess.getOutputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(stdin, StandardCharsets.UTF_8));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stout, StandardCharsets.UTF_8));
                String load = ":load temp.hs";
                String[] setCommands = {load, "main"};
                int counter = 1;
                // Load the compiled .hs file and run the main method
                writer.write(setCommands[0]);
                writer.newLine();
                writer.flush();

                String line;
                boolean hasOutput = false;
                while((line = reader.readLine()) != null){
                    System.out.println("* The program says: "+ line);
                    if (counter < setCommands.length){
                        writer = new BufferedWriter(new OutputStreamWriter(stout, StandardCharsets.UTF_8));
                        writer.write(setCommands[counter]);
                        writer.newLine();
                        writer.flush();
                        counter++;
                    }
                }
                writer.close();
            }catch(Exception e) {
                System.out.println("Exception Raised" + e.toString());
            }

        } else{
            // throw exception
            System.out.println("you sucks :C");
        }
    }

    public static void main(String[] args) {
        String fileToCompile = args[0];

        String[] temp = fileToCompile.split("\\.");
        String name   = temp[0];

        // create a new Compiler object
        MyCompiler compiler = new MyCompiler(name);

        // run compiler with a name of a file in args
        compiler.runHSFile();
    }
}
