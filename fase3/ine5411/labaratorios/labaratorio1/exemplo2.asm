.text
.globl main
	
main:
	add $s0, $zero, $gp
	lbu $t0, 0($s0)
	lbu $t1, 1($s0)
	lbu $t2, 2($s0)
	lbu $t3, 3($s0)
	lbu $t4, 4($s0)
	lbu $t5, 5($s0)
	lbu $t6, 6($s0)
	lbu $t7, 7($s0)
	lw $t8, 0($s0)