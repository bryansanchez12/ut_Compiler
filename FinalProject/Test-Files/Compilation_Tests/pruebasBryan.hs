import Sprockell
prog :: [Instruction]
prog = [
				Load (ImmValue 5) regA ,
				Store regA (DirAddr 0) ,
				Load (ImmValue 10) regA ,
				Store regA (DirAddr 1) ,
				Load (ImmValue 0) regA ,
				Store regA (DirAddr 2) ,
				Load (DirAddr 2) regA ,
				Load (ImmValue 5) regB ,
				Compute Lt regA regB regA ,
				Store regA (DirAddr 4) ,
				Load (ImmValue 1) regB ,
				Compute Xor regA regB regA ,
				Branch regA (Abs 26) ,
				Load (DirAddr 0) regA ,
				Load (ImmValue 5) regB ,
				Compute Add regA regB regA ,
				Store regA (DirAddr 0) ,
				Load (DirAddr 1) regA ,
				Load (DirAddr 0) regB ,
				Compute Add regA regB regA ,
				Store regA (DirAddr 1) ,
				Load (DirAddr 2) regA ,
				Load (ImmValue 1) regB ,
				Compute Add regA regB regA ,
				Store regA (DirAddr 2) ,
				Jump (Rel (-19)) ,
				Load (DirAddr 1) regA ,
				WriteInstr regA numberIO ,
				EndProg]


main = run [prog] 
