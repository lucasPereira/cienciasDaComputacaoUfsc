.data
i: .word 0
k: .word 4
save: .word 4, 4, 4, 5, 9, 5, 6, 4

.text
.globl main

main:
lw $s3, i
lw $s5, k
la $s6, save

Loop:
sll $t0, $s3, 2
add $t1, $t0, $s6
lw $s0, 0($t1)
bne  $s0, $s5, Exit
addi $s3, $s3, 1
j Loop

Exit:
addi $v0, $zero, 1
add $a0, $zero, $s3
syscall