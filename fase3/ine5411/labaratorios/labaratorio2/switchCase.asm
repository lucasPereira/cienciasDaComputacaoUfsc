.data

#01
f: .word 0
g: .word 4
h: .word 1
i: .word 4
j: .word 6

#02
jat:
	.word L0
	.word L1
	.word L2
	.word L3
	.word default

.text
.globl main
main:
		
#03
lw $s0, f
lw $s1, g
lw $s2, h
lw $s3, i
lw $s4 j
addi $s5, $zero, 4

la $t0, jat

#04
sltiu $t1, $s5, 4 #Se k estiver no intervalo (K < 4), então $t1 = 1, se não $t1 = 0
beq $t1, $zero, default

#05
sll $t1, $s5, 2 
add $t1, $t1, $t0

#06
lw $t1, 0($t1)
jr $t1

#07
L0:
	add $s0, $s3, $s4
	jal exit

L1:
	add $s0, $s1, $s2
	add $s0, $s0, $s5
	jal exit
	
L2:
	sub $s0, $s1, $s2
	jal exit
	
L3: 
	sub $s0, $s3, $s4
	jal exit	
	
default:
	sub $s0, $s3, $s4
	add $s0, $s0, $s2
	
exit:
	subi $t9, $zero, 1