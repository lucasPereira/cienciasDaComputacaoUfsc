// Modelo De Phong
// Chrystian De Souza Guth (10103131)
// Lucas Pereira Da Silva (10100754)

varying vec3 observador;
varying vec3 fonteDeLuz;
varying vec3 normalDaSuperficie;
varying float atenuacaoDaLuz;

void main() {
	vec4 intensidadeDaFonteDeLuzDifusa = gl_LightSource[0].diffuse;
	vec4 intensidadeDaFonteDeLuzEspecular = gl_LightSource[0].specular;
	vec4 intensidadeDaFonteDeLuzAmbiente = gl_LightSource[0].ambient;

	vec4 reflectividadeDifusaDaSuperficie = gl_FrontMaterial.diffuse;
	vec4 reflectividadeEspecularDaSuperficie = gl_FrontMaterial.specular;
	vec4 reflectividadeAmbienteDaSuperficie = gl_FrontMaterial.ambient;

	vec3 fonteDeLuzNormalizada = normalize(fonteDeLuz);
	vec3 observadorNormalizado = normalize(observador);
	vec3 normalDaSuperficieNormalizada = normalize(normalDaSuperficie);
	vec3 raioDeReflexaoNormalizado = reflect(-fonteDeLuzNormalizada, normalDaSuperficieNormalizada);

	vec4 intensidadeDaLuzDifusa = ( 
		intensidadeDaFonteDeLuzDifusa * 
		reflectividadeDifusaDaSuperficie * 
		dot(fonteDeLuzNormalizada, normalDaSuperficieNormalizada) *
		atenuacaoDaLuz
	);
	
	float expoenteEspecular = gl_FrontMaterial.shininess;
	vec4 intensidadeDaLuzEspecular = (
		intensidadeDaFonteDeLuzEspecular *
		reflectividadeEspecularDaSuperficie *
		pow(max(dot(raioDeReflexaoNormalizado, observadorNormalizado), 0.0), expoenteEspecular) *
		atenuacaoDaLuz
	);
	
	vec4 intensidadeGlobalDeLuzAmbiente = gl_FrontLightModelProduct.sceneColor;
	vec4 intensidadeDaLuzAmbiente = (
		intensidadeGlobalDeLuzAmbiente *
		reflectividadeAmbienteDaSuperficie
	);							
	
	vec4 intensidadeDaLuz = intensidadeDaFonteDeLuzAmbiente * reflectividadeAmbienteDaSuperficie * atenuacaoDaLuz;
	intensidadeDaLuz += intensidadeDaLuzDifusa;
	intensidadeDaLuz += intensidadeDaLuzEspecular;
	intensidadeDaLuz += intensidadeDaLuzAmbiente;
	gl_FragColor = intensidadeDaLuz;	
}
