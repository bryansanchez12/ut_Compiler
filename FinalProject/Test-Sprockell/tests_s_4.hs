import Sprockell

prog :: [Instruction]
prog = [  Load (ImmValue 5) regA
        , Store regA (DirAddr 0)
        , Load (ImmValue 10) regA
        , Store regA (DirAddr 1)
        , Load (ImmValue 0) regA
        , Load (ImmValue 1) regB
        , Compute Add regA regB regA
        , Store regA (DirAddr 3)
        , Load (ImmValue 1) regA
        , Branch regA (Abs 10)
        , Load (ImmValue 3) regA
        , Store regA (DirAddr 0)
        , Load (DirAddr 2) regA
        , Branch regA (Abs 14)
        , Load (ImmValue 3) regA
        , Store regA (DirAddr 0)
        , Branch regA (Abs 16)
        , Load (ImmValue 0) regA
        , Load (ImmValue 0) regB
        , Compute Gt regA regB regA
        , Store regA (DirAddr 5)
        , Branch regA (Abs 21)
        , Load (ImmValue 0) regA
        , Load (ImmValue 0) regB
        , Compute Gt regA regB regA
        , Store regA (DirAddr 5)
        , Branch regA (Abs 26)
        , Load (ImmValue 3) regA
        , Load (ImmValue 3) regB
        , Compute Add regA regB regA
        , Store regA (DirAddr 0)
         	
        , WriteInstr regA numberIO       -- output regA
                 -- "end"
        , EndProg
        ]

-- run the prog on 1 Sprockell core
main = run [prog]
