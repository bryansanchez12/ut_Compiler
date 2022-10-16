import Sprockell
prog :: [Instruction]
prog = [
				Load (ImmValue 10) regA ,
				Store regA (DirAddr 0) ,
				Load (ImmValue 5) regA ,
				Store regA (DirAddr 1) ,
				Load (ImmValue 0) regA ,
				Load (ImmValue 0) regB ,
				Load (DirAddr 0) regD ,
				Load (DirAddr 1) regD ,
				Compute Gt regB regD regF ,
				Branch regF (Abs 13) ,
				Compute Incr regA regA regA ,
				Compute Sub regD regC regD ,
				Jump (Rel (-4)) ,
				Compute Decr regA regA regA ,
				Store regA (DirAddr 2) ,
				Load (DirAddr 2) regA ,
				WriteInstr regA numberIO ,
				EndProg]


main = run [prog] 
