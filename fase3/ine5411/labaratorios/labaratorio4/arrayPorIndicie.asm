.data
array: .word 1, 2, 3, 4, 5, 6, 7, 8, 9, 2, 3
size: .word 11

.text
.globl main

main:
	jal clear
	li $v0, 10
	syscall
clear:
	la $a0, array
	lw $a1, size
	add $t0, $zero, $zero		#i = 0
loop:	
	slt $t3, $t0, $a1
	beq $t3, $zero, exit
		sll $t3, $t0, 2
		add $t3, $a0, $t3
		sw $zero, 0($t3)
		addi $t0, $t0, 1
		j loop
exit:
	jr $ra