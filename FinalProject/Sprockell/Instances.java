package pp.FinalProject.Sprockell;

public class Instances {

    private String label;
    private Instructions instruction;
    private String[] operations;

    public Instances(Instructions instruction, String... operations) {
        this.instruction = instruction;
        this.operations = operations;
    }

    public Instances(String label, Instructions instruction, String... operations) {
        this.label = label;
        this.instruction = instruction;
        this.operations = operations;
    }

    public Instructions getInstruction() {
        return this.instruction;
    }

    public String[] getOperations() {
        return this.operations;
    }

    public String getLabel() {
        return label;
    }

}
