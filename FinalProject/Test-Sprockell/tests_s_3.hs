import Sprockell

{-|
    boolean x = True;
    boolean y = False;

    boolean z = x && y

-}


prog :: [Instruction]
prog = [ Load (ImmValue 0) regA         -- load x = 0
       , Load (ImmValue 1) regB         -- load const 1
       , Compute And regA regB regC     -- check if i > 9, then stores the boolean in regC
       , WriteInstr regC numberIO       -- output regA

       -- "end"
       , EndProg
       ]

-- run the prog on 1 Sprockell core
main = run [prog]

