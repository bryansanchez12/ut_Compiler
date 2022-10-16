package pp.FinalProject.Sprockell;

public enum Registers {
    Addr,
    RegA,
    RegB,
    RegC,
    RegD,
    RegE,
    RegF;

    public String toString(){
        switch (this) {
            case Addr: return "Addr";
            case RegA: return "regA";
            case RegB: return "regB";
            case RegC: return "regC";
            case RegD: return "regD";
            case RegE: return "regE";
            case RegF: return "regF";
        }
        return null;
    }
}
