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
	add $t0, $a0, $zero		#p = &array[0]
loop:	
	sll $t2, $a1, 2
	add $t2, $t2, $a0
	slt $t3, $t0, $t2
	beq $t3, $zero, exit
		sw $zero, 0($t0)
		addi, $t0, $t0, 4
		j loop
exit:
	jr $ra