import Sprockell

{-
int total = x/y

    int x = 10;
    int y = 5;
    int counter = 0;

    for (int x; x > 0; x - y) {
        counter = counter  + 1;
    };

-}
{--
prog :: [Instruction]
prog = [ Load (ImmValue 0) regA         -- load counter = 0
       , Load (ImmValue 1) regE         -- load const 1, for counter ++
       , Load (ImmValue 10) regD        -- load int x
       , Load (ImmValue 0) regB         -- load 0 for > 0
       , Load (ImmValue 5) regC         -- load int y
       , Compute Gt regB regD regF     -- check if 0 > 10, then stores the boolean in regF
       , Branch regF (Abs 10)            -- if regF is True then go to EndProg, otherwise continue
       , Compute Add regA regE regA     -- counter + 1, stores in regA
       , Compute Sub regD regC regD     -- x - y, stores in regD
       , Jump (Rel (-4))
       , Compute Sub regA regE regA    -- counter - 1
       , WriteInstr regA numberIO       -- output regA
       -- "end"
       , EndProg
       ]
-}

{-
prog :: [Instruction]
prog = [ Load (ImmValue 0) regA         -- load counter = 0
       , Load (ImmValue 10) regD        -- load int x
       , Load (ImmValue 0) regB         -- load 0 for > 0
       , Load (ImmValue 1) regC         -- load int y
       , Compute Gt regB regD regF     -- check if 0 > 10, then stores the boolean in regF
       , Branch regF (Abs 9)            -- if regF is True then go to EndProg, otherwise continue
       , Compute Incr regA regA regA     -- counter + 1, stores in regA
       , Compute Sub regD regC regD     -- x - y, stores in regD
       , Jump (Rel (-4))
       , Compute Decr regA regA regA    -- counter - 1
       , WriteInstr regA numberIO       -- output regA
       -- "end"
       , EndProg
       ]    
-}

prog :: [Instruction]
prog = [ Load (DirAddr 5) 3
       , Load (DirAddr 5) regA
       , WriteInstr regA numberIO   
       , EndProg
       ] 

-- run the prog on 1 Sprockell core
main = run [prog]