import Sprockell

{-|
    int x = 0;

    for (int i = 0 ; i < 9 ; i ++ {
        x++;
    }
-}


prog :: [Instruction]
prog = [ Load (ImmValue 0) regA         -- load x = 0
       , Load (ImmValue 1) regE         -- load const 1
       , Load (ImmValue 0) regD         -- load i = 0
       , Load (ImmValue 9) regB         -- load boundary = 10
       , Compute GtE regD regB regC      -- check if i > 9, then stores the boolean in regC
       , Branch regC (Abs 9)            -- if regC is True then go to EndProg, otherwise continue
       , Compute Add regA regE regA     -- x + 1, stores in regA
       , Compute Add regD regE regD     -- i + 1, stores in regD
       , Jump (Rel (-4))
       , WriteInstr regA numberIO       -- output regA
       -- "end"
       , EndProg
       ]

prog1 :: [Instruction]
prog1 = [ Load (ImmValue 1) regA         -- load x = 0
        , Load (ImmValue 0) regB         -- load const 1
        , Compute GtE regD regB regC      -- check if i > 9, then stores the boolean in regC
        , Branch regC (Abs 9)            -- if regC is True then go to EndProg, otherwise continue
        , Compute Add regA regE regA     -- x + 1, stores in regA
        , Compute Add regD regE regD     -- i + 1, stores in regD
        , Jump (Rel (-4))
        , WriteInstr regA numberIO       -- output regA

       -- "end"
        , EndProg
       ]
       
prog2 :: [Instruction]
prog2 = [Load (ImmValue 5) regA
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
         	, Branch regA (Abs 22)
         	, Load (DirAddr 2) regA
         	, Load (ImmValue 1) regB
         	, Compute Add regA regB regA
         	, Store regA (DirAddr 2)
         	, Load (DirAddr 0) regA
         	, Load (ImmValue 5) regB
         	, Compute Add regA regB regA
         	, Store regA (DirAddr 0)
         	, Jump (Rel (-15))
          
       ,  Load (DirAddr 0) regA 
       , WriteInstr regA numberIO       -- output regA

      -- "end"
       , EndProg
      ]

-- run the prog on 1 Sprockell core
main = run [prog]

-- run the prog on 1 Sprockell core
main1 = run [prog1]

-- run the prog on 1 Sprockell core
main2 = run [prog2]












