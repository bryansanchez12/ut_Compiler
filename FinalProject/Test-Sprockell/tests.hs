import Sprockell

{-|
    int x = 7;
    int y = 3;

    if (x > y){
        x = 5
    }
-}


prog :: [Instruction]
prog = [ Load (ImmValue 21) regA         -- load x = 7
       , Load (ImmValue 45) regB         -- load y = 3
       , Compute Gt regB regA regC      -- check if x > y, then stores the boolean in

       , Branch regC (Abs 6)            -- if regC is True then go to EndProg, otherwise continue
       , Load (ImmValue 66) regA
       , WriteInstr regA numberIO       -- output regA

       -- "end"
       , EndProg
       ]

-- run the prog on 1 Sprockell core
main = run [prog]