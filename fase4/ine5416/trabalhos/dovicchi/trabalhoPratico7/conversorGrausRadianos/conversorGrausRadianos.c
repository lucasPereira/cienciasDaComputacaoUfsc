#include "ConversorGrausRadianos.h"

float* converterParaGraus(float* radianos) {
	float* graus = (float*) malloc(sizeof(float));
	*graus = *radianos*(180/PI);
	
	return graus;
}

float* converterParaRadianos(float* graus) {
	float* radianos = (float*) malloc(sizeof(float));
	*radianos = *graus*(PI/180);
	
	return radianos;
}
