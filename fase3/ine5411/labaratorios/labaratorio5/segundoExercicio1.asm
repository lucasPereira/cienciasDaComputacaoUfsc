.data
_v: .word 9, 8, 7, 6 , 5, 4, 3, 2, 1, -1
_n: .word 10

.text
.globl main

main:
	la   $a0,_v  
	lw   $a1,_n 
	jal sort
	li  $v0,10      #Exit syscall
	syscall

sort:
	addi $sp,$sp,-12 
	sw   $ra,8($sp) 
	sw   $s1,4($sp)  
	sw   $s0,0($sp)  
  	move $s0,$zero
	for1tst:
		nop #MARCA 1
		slt  $t0,$s0,$a1 # for1st
		beq  $t0,$zero,exit1  
		addi $s1,$s0,-1  
		for2tst:
			slti $t0,$s1,0  # for2st
			bne  $t0,$zero,exit2 
			sll  $t1,$s1,2   
			add  $t2,$a0,$t1 
			lw   $t3,0($t2)
			lw   $t4,4($t2)
			slt  $t0,$t4,$t3
			beq  $t0,$zero,exit2
			nop # MARCA 2
			jal  swap 	# chamada de swap
			addi $s1,$s1,-1
			j    for2tst
	exit2:
		addi $s0,$s0,1
		j    for1tst
	exit1:
		lw   $s0,0($sp)  
		lw   $s1,4($sp)
		lw   $ra,8($sp)
		addi $sp,$sp,12
		jr   $ra
		
swap:
	sll $t2, $a1, 2
	add $t2, $t2, $a0
	lw $t0, 0($t2)
	lw $t1, 4($t2)
	sw $t0, 4($t2)
	sw $t1, 0($t2)
	jr  $ra