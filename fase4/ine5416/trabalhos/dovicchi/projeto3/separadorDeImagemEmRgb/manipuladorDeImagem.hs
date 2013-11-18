-- Aluno: Chrystian de Sousa Guth

module ManipuladorDeImagem(
	removerCabecalho,
	removerPadding,
	obterLargura,
	obterPontosDeCor,
	ordenarPontosDeCor,
	escreverNoArquivo
) where

import List
import System.IO
import Char

removerCabecalho :: [Char] -> ([Char],[Char])
removerCabecalho [] = ([],[])
removerCabecalho imagem = splitAt 54 imagem

obterLargura :: [Char] -> Int
obterLargura [] = 0
obterLargura cabecalho = let lista = map ord (take 4 (drop 18 cabecalho))  in  (lista!!0)+(lista!!1)*256

removerPadding :: [Char] -> Int -> [Char]
removerPadding [] _ = []
removerPadding imagem largura = let (atual, resto) = splitAt (largura*3) imagem
				    padding = mod (largura*3) 4  in
				       let proximasLinhas = drop padding resto  in
					       atual ++ (removerPadding proximasLinhas largura)

obterPontosDeCor :: [Char] -> [[Char]]
obterPontosDeCor [] = [] 
obterPontosDeCor arquivo = (take 3 arquivo):(obterPontosDeCor (drop 3 arquivo) )

ordenarPontosDeCor :: Int -> [Char] -> [[Char]]
ordenarPontosDeCor largura porLinha = reverse (separarPontosDeCor largura porLinha)

separarPontosDeCor ::  Int -> [Char] -> [ [Char] ]
separarPontosDeCor largura [] = []
separarPontosDeCor largura pl = let s = splitAt largura pl in
				(fst s):(separarPontosDeCor largura (snd s))

escreverNoArquivo arquivo [] = return ()
escreverNoArquivo arquivo lista = do
					hPrint arquivo (show (map ord (head lista)))
					escreverNoArquivo arquivo (tail lista)
