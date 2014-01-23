#!/bin/bash

identificadoresDasChaves=(
	EDB079BF
	0635E923
	039B68E1
	D7C6102A
	E710D45F
	87C5AB55
	4DB0E56C
	BB5ADAE9
	A722D484
	81054B06
	E2EE1E2F
	80FBB35F
	EFB9B833
	4B694A7C
	CAA7B600
	242059D6
	92DADCF7
	426EE502
	B738DF52
	0B0C5267
	72E5E082
	36F291ED
	66A5959F
	EEA89C06
	17447C0A
	9F3016A9
	E5404A15
	E4F2890D
	15AAB959
	0FC291F2
	C5DC84F3
	3EFEABCC
	C6E2495B
	FB5B0D51
)
identificadorDaMinhaChave=72E5E082
for identificadorDaChave in ${identificadoresDasChaves[@]}
do
	gpg --keyserver keyserver.cais.rnp.br --recv-key $identificadorDaChave
	gpg -u $identificadorDaMinhaChave --keyserver keyserver.cais.rnp.br --sign-key $identificadorDaChave
	gpg --keyserver keyserver.cais.rnp.br --send-key $identificadorDaChave
done
gpg --keyserver keyserver.cais.rnp.br --refresh-keys
