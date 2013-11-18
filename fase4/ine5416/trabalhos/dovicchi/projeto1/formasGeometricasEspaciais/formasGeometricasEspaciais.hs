module FormasGeometricasEspaciais(
	Forma(Esfera, Cilindro, Cone, TroncoDeCone, EsferoideOblato, EsferoideProblato),
	Raio,
	Altura,
	RaioDaBase,
	RaioDaSeccao,
	SemiEixoMaior,
	SemiEixoMenor
) where

data Forma = Esfera Raio
	| Cilindro RaioDaBase Altura
	| Cone RaioDaBase Altura
	| TroncoDeCone RaioDaBase RaioDaSeccao Altura
	| EsferoideOblato SemiEixoMaior SemiEixoMenor 
	| EsferoideProblato SemiEixoMaior SemiEixoMenor 
	deriving Show

type RaioDaBase = Float
type Raio = Float
type Altura = Float
type RaioDaSeccao = Float
type SemiEixoMaior = Float
type SemiEixoMenor = Float

volume :: Forma -> Float
volume(Esfera raio) = (4/3)*pi*raio*raio*raio
volume(Cilindro raio altura) = pi*raio*raio*altura
volume(Cone raio altura) = (1/3)*pi*raio*raio*altura
volume(TroncoDeCone raioA raioB altura) = (1/3)*pi*altura*((raioA*raioA)+(raioB*raioB)+(raioA*raioB))
volume(EsferoideOblato a b) = ((4/3)*pi*a*a*b)
volume(EsferoideProblato a b) = ((4/3)*pi*a*b*b)

areaTotal :: Forma -> Float
areaTotal (Esfera raio) = 4*pi*raio*raio
areaTotal (Cilindro raio altura) = areaLateral(Cilindro raio altura)+2*pi*raio*raio
areaTotal (Cone raio altura) = pi*raio*(sqrt((raio*raio)+(altura*altura))+raio)
areaTotal (TroncoDeCone raioA raioB altura) = pi*raioA*raioA+pi*raioB*raioB+areaLateral(TroncoDeCone raioA raioB altura)
areaTotal (EsferoideOblato a b) = (2*pi*a*a)+(((b*b)/(excentricidade a b))*log((1+((excentricidade a b)))/(1-((excentricidade a b)))))
areaTotal (EsferoideProblato a b) = (2*pi*b*b)+(2*pi*((a*b)/excentricidade a b)*asin(excentricidade a b)) 

areaLateral :: Forma -> Float
areaLateral(Cilindro raio altura) = 2*raio*altura
areaLateral(Cone raio altura) = pi*raio*sqrt((raio*raio)+(altura*altura))
areaLateral(TroncoDeCone raioA raioB altura) = pi*(raioA+raioB)*sqrt((altura*altura)+((raioA-raioB)*(raioA-raioB)))

excentricidade :: SemiEixoMaior -> SemiEixoMenor -> Float
excentricidade a b = (sqrt((a*a)-(b*b)))/a 

