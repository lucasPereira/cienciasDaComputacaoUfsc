import System (getArgs)
import System.IO
import ManipuladorDeImagem
import List

main = do
	argumentos <- getArgs
	case argumentos of
		[nomeDoArquivo] -> do			
			arquivoDeImagem <- readFile nomeDoArquivo
			let (cabecalho, imagem) = removerCabecalho arquivoDeImagem
			let largura = obterLargura cabecalho
			let imagemSemPadding = removerPadding imagem largura
			let pontosDeCor = obterPontosDeCor imagemSemPadding
			let pontosDeCorSeparadosEmRgb = transpose pontosDeCor
			let pontosDeCorEmLinhaSeparadosEmRgb = map (ordenarPontosDeCor largura) pontosDeCorSeparadosEmRgb
			let nomeDoArquivoSemExtensao = take (length nomeDoArquivo - 4) nomeDoArquivo
			let nomeDosArquivosSeparadosEmRgb = map (nomeDoArquivoSemExtensao++) [".vermelho.txt", ".verde.txt", ".azul.txt"]
			arquivosSeparadosEmRgb <- sequence [openFile file WriteMode | file <- nomeDosArquivosSeparadosEmRgb]
			sequence [escreverNoArquivo arquivo conteudo | (arquivo, conteudo) <- zip arquivosSeparadosEmRgb pontosDeCorEmLinhaSeparadosEmRgb]
			sequence [hClose f | f <- arquivosSeparadosEmRgb]
			putStr "\n* Arquivo de imagem separado pelas cores RGB com sucesso."
			putStr "\n* Os seguintes arquivos foram criados:\n"
			putStr $ concat $ map ( ++ "\n") nomeDosArquivosSeparadosEmRgb
			putStr "\n"
		_ -> do
			putStr "\n* Passe o nome do arquivo do tipo .bmp como parametro.\n\n"
