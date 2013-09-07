.data
_v: .word 9, 8, 7, 6, 5, 4, 3, 2, 1, -1
_k: .word 2

.text
.globl main

main:
	la $a0, _v
	lw $a1, _k
	jal swap
	li $v0, 10
	syscall

swap:
	sll $t2, $a1, 2
	add $t2, $t2, $a0
	lw $t0, 0($t2)
	lw $t1, 4($t2)
	sw $t0, 4($t2)
	sw $t1, 0($t2)
	jr  $ra
