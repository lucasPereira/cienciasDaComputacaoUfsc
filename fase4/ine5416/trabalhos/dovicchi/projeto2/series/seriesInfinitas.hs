module SeriesInfinitas (quaseUm, quaseDois, quaseE) where

quaseUm n = sum(map (\x->(1/(x^2+x))) (take n [1..]))
quaseDois n = sum(map(\x->(2/(x^2+x))) (take n [1..]))
quaseE n = 1 + sum(map(\x->(1/fatorial x)) (take n [1..]))
fatorial 0 = 1
fatorial n = n*fatorial(n-1)
