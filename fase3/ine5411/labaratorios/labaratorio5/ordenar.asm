.data
array: .word 5, 4, 3, 2, 1
size: .word 5

.text
.globl main

main:
	la $a0, array
	lw $a1, size
	jal sort
	j end

sort:
	# Salva na pilha os registradores que serão usados
	addi $sp, $sp, -20
	sw $ra, 16($sp)
	sw $s3, 12($sp)
	sw $s2, 8($sp)
	sw $s1, 4($sp)
	sw $s0, 0($sp)	
	# Salva os argumentos
	add $s2, $a0, $zero 	
	add $s3, $a1, $zero
	# Inicializa i=0
	add $s0, $zero, $zero	
	for1tst:
		slt $t0, $s0, $s3		# $t0 recebe 0 se $s0 >= $s3
		beq $t0, $zero, exit1	
		addi $s1, $s0, -1		
		for2tst:
			slt $t0, $s1, $zero		# $t0 recebe 1 se $s1 < 0
			bne $t0, $zero exit2
			add $t1, $s1, $s1
			add $t1, $t1, $t1
			add $t2, $s2, $t1
			lw $t3, 0($t2)
			lw $t4, 4($t2)
			slt $t0, $t4, $t3		# $t0 recebe 0 se $t3 >= $t3
			beq	$t0, $zero, exit2
			add $a0, $s2, $zero
			add $a1, $s1, $zero
			jal swap
			addi $s1, $s1, -1
			j for2tst
		exit2:
			addi $s0,  $s0, 1
			j for1tst
	exit1:
		lw $s0, 0($sp)
		lw $s1, 4($sp)
		lw $s2, 8($sp)
		lw $s3, 12($sp)
		lw $ra, 16 ($sp)
		addi $sp, $sp, 20
		jr $ra

swap:
	# Pega a posição de memória de v[k]
	sll $t2, $a1, 2			
	add $t2, $t2, $a0
	# Adiciona v[k] à $t0 e v[k+1] a $t1
	lw $t0, 0($t2)
	lw $t1, 4($t2)
	# Faz o swap: v[k] = v[k+1] e v[k+1] = v[k]
	sw $t0, 4($t2)
	sw $t1, 0($t2)
	jr $ra

end: