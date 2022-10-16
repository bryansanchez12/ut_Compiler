package pp.FinalProject.Sprockell;

public enum Instructions {

    COMPUTE,
    JUMP,
    BRANCH,

    LOAD,

    STORE,

    PUSH,
    POP,

    ReadInstr,
    RECEIVE,
    WriteInstr,
    TestAndSet,

    EndProg,

    NOP,

    DEBUG;

    public String toString(){
        switch (this) {
            case COMPUTE: return "Compute";
            case JUMP: return "Jump";
            case BRANCH: return "Branch";

            case LOAD: return "Load";

            case STORE: return "Store";

            case PUSH: return "Push";
            case POP: return "Pop";

            case ReadInstr: return "ReadInstr";
            case RECEIVE: return "Receive";
            case WriteInstr: return "WriteInstr";
            case TestAndSet: return "TestAndSet";

            case EndProg: return "EndProg";

            case NOP: return "Nop";

            case DEBUG: return "Debug";
        }
        return null;
    }

    }
