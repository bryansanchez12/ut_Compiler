package pp.FinalProject.Sprockell;

public enum Operators {
    // Computational operations
    ADD,
    SUB,
    MUL,  //  | Mod     -- No Div, Mod because of hardware complexity
    DIV,

    //Comparison operations
    EQUAL,
    NEQ,
    GT,
    LT,
    GTE,
    LTE,

    // Logical operations
    AND,
    OR,
    XOR,
    LSHIFT,
    RSHIFT,

    // Decrement (-1), Increment (+1)
    DECR,
    INCR;

    public String toString(){
        switch (this) {
            case ADD: return "Add";
            case SUB: return "Sub";
            case MUL: return "Mul";

            case EQUAL: return "Equal";
            case NEQ: return "NEq";
            case GT: return "Gt";
            case LT: return "Lt";
            case GTE: return "GtE";
            case LTE: return "LtE";

            case AND: return "And";
            case OR: return "Or";
            case XOR: return "Xor";
            case LSHIFT: return "LShift";
            case RSHIFT: return "RShift";

            case DECR: return "Decr";
            case INCR: return "Incr";
        }
        return null;
    }

}
