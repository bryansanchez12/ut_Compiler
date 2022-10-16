import Sprockell

{-|
    int x = 0;

    while ( x < 5 ){
        x = x + 1 ;
    }
-}

prog :: [Instruction]
prog = [ Load (ImmValue 0) regA         -- load x = 0
       , Store regA (DirAddr 0)
       , Load (DirAddr 0) regA          -- load x
       , Load (ImmValue 5) regB
       , Compute Lt regA regB regA      -- check if i < 5, then stores the boolean in regC
       -- change boolean
       , Load (ImmValue 1) regB         -- load value 1
       , Compute Xor regA regB regA     -- if equal true, false otherwise
       -- go to branch if true
       , Branch regA (Abs 13)            -- if regC is True then go to EndProg, otherwise continue
       -- if branch false do :
       , Load (DirAddr 0) regA 
       , Load (ImmValue 2) regB
       , Compute Add regA regB regA
       , Store regA (DirAddr 0)
       , Jump (Rel (-10))
       -- if branch true do :
       , Load (DirAddr 0) regA 
       , WriteInstr regA numberIO       -- output regA
       -- "end"
       , EndProg
       ]

prog1 :: [Instruction]
prog1 = [Load (ImmValue 5) regA
         	, Store regA (DirAddr 0)
         	, Load (ImmValue 10) regA
         	, Store regA (DirAddr 1)
         	, Load (ImmValue 0) regA
         	, Store regA (DirAddr 2)
         	, Load (DirAddr 2) regA
         	, Load (ImmValue 5) regB
         	, Compute Lt regA regB regA
         	, Store regA (DirAddr 4)
         	, Load (ImmValue 1) regB
         	, Compute Xor regA regB regA
         	, Branch regA (Abs 26)
         	, Load (DirAddr 0) regA
         	, Load (ImmValue 5) regB
         	, Compute Add regA regB regA
         	, Store regA (DirAddr 0)
         	, Load (DirAddr 1) regA
         	, Load (DirAddr 0) regB
         	, Compute Add regA regB regA
         	, Store regA (DirAddr 1)
         	, Load (DirAddr 2) regA
         	, Load (ImmValue 1) regB
         	, Compute Add regA regB regA
         	, Store regA (DirAddr 2)
         	, Jump (Rel (-19))
          	
        ,  Load (DirAddr 1) regA 
        , WriteInstr regA numberIO       -- output regA

       -- "end"
        , EndProg
       ]

-- run the prog on 1 Sprockell core
main = run [prog]

-- run the prog on 1 Sprockell core
main1 = run [prog1]















