// Modelo De Phong
// Chrystian De Souza Guth (10103131)
// Lucas Pereira Da Silva (10100754)

varying vec3 fonteDeLuz;
varying vec3 observador;
varying vec3 normalDaSuperficie;
varying float atenuacaoDaLuz;

void main() {	
	vec3 vertex = vec3(gl_ModelViewMatrix * gl_Vertex);
	fonteDeLuz = vec3(gl_LightSource[0].position.xyz - vertex);
	observador = -vertex;
	normalDaSuperficie = gl_NormalMatrix * gl_Normal;
	float distanciaDaFonteDeLuz = length(fonteDeLuz);
	float distanciaQuadraticaDaFonteDeLuz = distanciaDaFonteDeLuz * distanciaDaFonteDeLuz;
	atenuacaoDaLuz = 1.0 / (
		(gl_LightSource[0].constantAttenuation) + 
		(gl_LightSource[0].linearAttenuation * distanciaDaFonteDeLuz) + 
		(gl_LightSource[0].quadraticAttenuation * distanciaQuadraticaDaFonteDeLuz)
	);
	gl_Position = ftransform();		
}