module SeriesFinitas(
	somaInteiros, totalInteiros, 
	somaImpares, totalImpares, 
	somaPares, totalPares, 
	somaQuadradoDosInteiros, totalQuadradoDosInteiros, 
	somaQuadradoDosImpares, totalQuadradoDosImpares
) where

somaInteiros n = map (\x->(x*(x+1)/2)) [1..n]
totalInteiros n = last(somaInteiros n)

somaImpares n = map(\x->(x*(1+ (x*2-1))/2)) [1..n]
totalImpares n = last (somaImpares n)

somaPares n = map(\x->(x*(2 + 2*x)/2)) [1..n]
totalPares n = last(somaPares n)

somaQuadradoDosInteiros n = map(\x->((x*(1+ x)*(2*x+1))/6)) [1..n]
totalQuadradoDosInteiros n = last(somaQuadradoDosInteiros n)

somaQuadradoDosImpares n = map(\x->((x*(2*x-1)*(2*x+1))/3)) [1..n]
totalQuadradoDosImpares n = last(somaQuadradoDosImpares n)
