.data
i: .word 0
save: .word 99999, 8, 4, 4, 4, 4, 4, 4, 4, 4
k: .word 4
error: .asciiz "Index Out if Bounds Exception"

.text
.globl main

main:
lw $s3, i
lw $s5, k
la $s6, save
lw $t2, 4($s6)
addi $s6, $s6, 8

Loop:
sltu $t1, $s3, $t2
beq $t1, $zero, IndexOutOfBounds
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
j End

IndexOutOfBounds:
addi $v0, $zero, 4
la $a0, error
syscall

End: