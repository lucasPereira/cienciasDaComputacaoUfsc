module AnaliseCombinatoria (fatorial,
							arranjoSimples, arranjoComRepetição,
							permutaçãoSimples, permutaçãoComRepetição, permutaçãoCircular,
							combinaçãoSimples, combinaçãoComRepetição) where

exponencial :: (Integral t) => t -> t -> t
exponencial a 0 = 1
exponencial a b = a * exponencial a (b - 1)

produtório :: (Num t) => [t] -> t
produtório [] = 1
produtório (x:xs) = x * produtório xs

fatorial :: (Integral t) => t -> t
fatorial 0 = 1
fatorial n = n * fatorial (n - 1)

arranjoSimples :: (Integral t) => t -> t -> t
arranjoSimples n p = fatorial n `div` fatorial (n - p)

arranjoComRepetição :: (Integral t) => t -> t -> t
arranjoComRepetição n p = exponencial n p

permutaçãoSimples :: (Integral t) => t -> t
permutaçãoSimples n = fatorial n

permutaçãoComRepetição :: (Integral t) => t -> [t] -> t
permutaçãoComRepetição n [] = fatorial n
permutaçãoComRepetição n [xs] = fatorial n `div` produtório [fatorial x | x <- [xs]]

permutaçãoCircular :: (Integral t) => t -> t
permutaçãoCircular n = permutaçãoSimples (n - 1)

combinaçãoSimples :: (Integral t) => t -> t -> t
combinaçãoSimples n p = fatorial n `div` (fatorial p * fatorial (n - p))

combinaçãoComRepetição :: (Integral t) => t -> t -> t
combinaçãoComRepetição n p = combinaçãoSimples (n+p-1) p
