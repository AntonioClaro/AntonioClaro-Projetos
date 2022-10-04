<?php
/**
 * As configurações básicas do WordPress
 *
 * O script de criação wp-config.php usa esse arquivo durante a instalação.
 * Você não precisa usar o site, você pode copiar este arquivo
 * para "wp-config.php" e preencher os valores.
 *
 * Este arquivo contém as seguintes configurações:
 *
 * * Configurações do banco de dados
 * * Chaves secretas
 * * Prefixo do banco de dados
 * * ABSPATH
 *
 * @link https://wordpress.org/support/article/editing-wp-config-php/
 *
 * @package WordPress
 */

// ** Configurações do banco de dados - Você pode pegar estas informações com o serviço de hospedagem ** //
/** O nome do banco de dados do WordPress */
define( 'DB_NAME', 'wordpressdb' );

/** Usuário do banco de dados MySQL */
define( 'DB_USER', 'root' );

/** Senha do banco de dados MySQL */
define( 'DB_PASSWORD', '' );

/** Nome do host do MySQL */
define( 'DB_HOST', 'localhost' );

/** Charset do banco de dados a ser usado na criação das tabelas. */
define( 'DB_CHARSET', 'utf8mb4' );

/** O tipo de Collate do banco de dados. Não altere isso se tiver dúvidas. */
define( 'DB_COLLATE', '' );

/**#@+
 * Chaves únicas de autenticação e salts.
 *
 * Altere cada chave para um frase única!
 * Você pode gerá-las
 * usando o {@link https://api.wordpress.org/secret-key/1.1/salt/ WordPress.org
 * secret-key service}
 * Você pode alterá-las a qualquer momento para invalidar quaisquer
 * cookies existentes. Isto irá forçar todos os
 * usuários a fazerem login novamente.
 *
 * @since 2.6.0
 */
define( 'AUTH_KEY',         'kt,|Bl/RN{=/@&}<Q|reMY6@D,Yg{i;!rGl9zT{fRfWjot0e,`/|f=d#VaD<Q6c~' );
define( 'SECURE_AUTH_KEY',  '=W3Nr&&pq;h}}J~ Xc!|Bf9w*^@@Uz=^m84ouQ4b%u$gExK*RFFRQxZmF#Es8@7r' );
define( 'LOGGED_IN_KEY',    '25}07eX^9pYnY%~N*J,*Dc qDzjo8SXAyJng}I|]]%}8m,X%)5]470=+*lPczyGf' );
define( 'NONCE_KEY',        ')dym6n2-z4+i~k+OF,yJNEqSCR}U(gA_|MmGOq:2Sn_`jZ{:2&d[TZex4FdMc]9Y' );
define( 'AUTH_SALT',        '+F=#NKa-4gj/9I)wIBa11oeG5{A)j,}@Tnc5l8-wvp-`~+kWYFr)};kJI+vtq2|f' );
define( 'SECURE_AUTH_SALT', '`*tu3]dT2ZN,!!r24s$4vKrSQFYV+8$o)k[[O+R=&(Cr(s}$qz@::WLVeU?nu7N`' );
define( 'LOGGED_IN_SALT',   'oe{9eHlL]`I?NGsFx9J2aDd+GoWx!/Pks%r9IDEs@/8f8Qls8s/fUFkVCJZ}]13G' );
define( 'NONCE_SALT',       't#zrzU/yR*AtT2Y7qg>m}*?()V[;>2`lQ =4UCw8a0iu >*!^i-#`rK^J@yb/Zq/' );

/**#@-*/

/**
 * Prefixo da tabela do banco de dados do WordPress.
 *
 * Você pode ter várias instalações em um único banco de dados se você der
 * um prefixo único para cada um. Somente números, letras e sublinhados!
 */
$table_prefix = 'wp_';

/**
 * Para desenvolvedores: Modo de debug do WordPress.
 *
 * Altere isto para true para ativar a exibição de avisos
 * durante o desenvolvimento. É altamente recomendável que os
 * desenvolvedores de plugins e temas usem o WP_DEBUG
 * em seus ambientes de desenvolvimento.
 *
 * Para informações sobre outras constantes que podem ser utilizadas
 * para depuração, visite o Codex.
 *
 * @link https://wordpress.org/support/article/debugging-in-wordpress/
 */
define( 'WP_DEBUG', false );

/* Adicione valores personalizados entre esta linha até "Isto é tudo". */



/* Isto é tudo, pode parar de editar! :) */

/** Caminho absoluto para o diretório WordPress. */
if ( ! defined( 'ABSPATH' ) ) {
	define( 'ABSPATH', __DIR__ . '/' );
}

/** Configura as variáveis e arquivos do WordPress. */
require_once ABSPATH . 'wp-settings.php';
