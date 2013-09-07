.text
.globl main

main: 
	add $s0, $zero, $gp
	lbu $t0, 0($s0)
	sb $t1, 1($s0)	