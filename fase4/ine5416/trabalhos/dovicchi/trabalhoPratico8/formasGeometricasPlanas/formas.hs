-- Aluno: Chrystian de Sousa Guth

module Formas(
	Forma(Retangulo, Elipse, TriangRetangulo, Poligono),
	Raio, 
	Lado, 
	Vertice,
	quadrado, 
	circulo,
	distancia,
	area	
) where

data Forma = Retangulo Lado Lado
		| Elipse Raio Raio
		| TriangRetangulo Lado Lado
		| Poligono [ Vertice ]
		deriving Show
		type Raio = Float
		type Lado = Float
		type Vertice = (Float, Float)
		quadrado lado = Retangulo lado lado
		circulo raio = Elipse raio raio
		
areaDoTriangulo :: Vertice -> Vertice -> Vertice -> Float
areaDoTriangulo a b c = let 
					a = distancia a b
					b = distancia b c
		       		c = distancia c a
					area = 0.5*(a+b+c)
					in sqrt (area*(area-a)*(area-b)*(area-c))
		   
distancia :: Vertice -> Vertice -> Float
distancia(x1, y1) (x2, y2) = sqrt((x1-x2)^2+(y1-y2)^2)

area :: Forma -> Float
area(Retangulo ladoA ladoB) = ladoA*ladoB
area(TriangRetangulo base altura) = base*altura/2
area(Elipse raioA raioB) = pi*raioA*raioB
area(Poligono(v1:vs)) = areaDoPoligono vs 
					where areaDoPoligono :: [Vertice] -> Float
					areaDoPoligono(v2:v3:vs') = areaDoTriangulo v1 v2 v3+areaDoPoligono( v3 : vs')
					areaDoPoligono _ = 0
