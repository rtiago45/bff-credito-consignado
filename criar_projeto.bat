@echo off
set BASE_PACKAGE=com\bffcredito

:: Criar estrutura de diretórios dentro da pasta já existente
mkdir "src\main\java\%BASE_PACKAGE%\config"
mkdir "src\main\java\%BASE_PACKAGE%\controller"
mkdir "src\main\java\%BASE_PACKAGE%\service"
mkdir "src\main\java\%BASE_PACKAGE%\repository"
mkdir "src\main\java\%BASE_PACKAGE%\dto"
mkdir "src\main\java\%BASE_PACKAGE%\model"
mkdir "src\main\java\%BASE_PACKAGE%\filter"
mkdir "src\main\resources"

:: Criar arquivos base dentro da estrutura
type nul > "src\main\java\%BASE_PACKAGE%\config\RedisConfig.java"
type nul > "src\main\java\%BASE_PACKAGE%\config\JwtUtil.java"
type nul > "src\main\java\%BASE_PACKAGE%\config\SecurityConfig.java"
type nul > "src\main\java\%BASE_PACKAGE%\config\CorsConfig.java"

type nul > "src\main\java\%BASE_PACKAGE%\controller\AuthController.java"
type nul > "src\main\java\%BASE_PACKAGE%\controller\SimulacaoController.java"
type nul > "src\main\java\%BASE_PACKAGE%\controller\PropostaController.java"

type nul > "src\main\java\%BASE_PACKAGE%\service\AuthService.java"
type nul > "src\main\java\%BASE_PACKAGE%\service\SimulacaoService.java"
type nul > "src\main\java\%BASE_PACKAGE%\service\PropostaService.java"

type nul > "src\main\java\%BASE_PACKAGE%\repository\SimulacaoRepository.java"
type nul > "src\main\java\%BASE_PACKAGE%\repository\PropostaRepository.java"

type nul > "src\main\java\%BASE_PACKAGE%\dto\LoginRequestDTO.java"
type nul > "src\main\java\%BASE_PACKAGE%\dto\LoginResponseDTO.java"
type nul > "src\main\java\%BASE_PACKAGE%\dto\SimulacaoDTO.java"
type nul > "src\main\java\%BASE_PACKAGE%\dto\PropostaDTO.java"

type nul > "src\main\java\%BASE_PACKAGE%\model\Simulacao.java"
type nul > "src\main\java\%BASE_PACKAGE%\model\Proposta.java"

type nul > "src\main\java\%BASE_PACKAGE%\filter\JwtAuthenticationFilter.java"

type nul > "src\main\java\%BASE_PACKAGE%\BffCreditoApplication.java"
type nul > "src\main\resources\application.yml"

echo ✅ Estrutura criada dentro da pasta do projeto 'bff-credito-consignado' com 