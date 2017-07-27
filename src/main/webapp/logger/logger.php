<html>
<head>
</head>

<title>Server Side Logger</title>

<body>

<?php

    $jsonstr = $_POST["data"];
    $log = new PHPLogger("logger.json");
    $log->writeToLog($jsonstr);

     /**
      * Simple logger class based on a similer class created by
      * Darko Bunic (http://www.redips.net/php/write-to-log-file/)
      * Does simple logging to a specified file. See https://bitbucket.org/huntlyc/simple-php-logger for more details.
      *
      * @package default
      * @author Huntly Cameron <huntly.cameron@gmail.com>
	  *
	  * Oct 15, 2012
	  * Modified by gcastillo@splunk.com
	  * removed $tag in favour of a plain text message.
      **/
    class PHPLogger{
        /**
         * log_file - the log file to write to
         *
         * @var string
         **/
        private $log_file;

        /**
         * Constructor
         * @param String logfile - [optional] Absolute file name/path. Defaults to ubuntu apache log.
         * @return void
         **/
        function __construct($log_file = "logger.json") {
            $this->log_file = $log_file;

            if(!file_exists($log_file)){ //Attempt to create log file
                touch($log_file);
            }

            //Make sure we'ge got permissions
            if(!(is_writable($log_file) || $this->win_is_writable($log_file))){
                //Cant write to file,
                throw new Exception("LOGGER ERROR: Can't write to log", 1);
            }
        }

        /**
         * writeToLog - writes out timestamped message to the log file as
         * defined by the $log_file class variable.
         *
         * @param String status - "INFO"/"DEBUG"/"ERROR" e.t.c.
         * @param String tag - "Small tag to help find log entries"
         * @param String message - The message you want to output.
         * @return void
         **/
        public function writeToLog($message) {
            file_put_contents($this->log_file, $message, FILE_APPEND);
            file_put_contents($this->log_file, "\n", FILE_APPEND);
        }

        //Function lifted from wordpress
        //see: http://core.trac.wordpress.org/browser/tags/3.3/wp-admin/includes/misc.php#L537
        private function win_is_writable( $path ) {
            /* will work in despite of Windows ACLs bug
             * NOTE: use a trailing slash for folders!!!
             * see http://bugs.php.net/bug.php?id=27609
             * see http://bugs.php.net/bug.php?id=30931
             */
            if ( $path[strlen( $path ) - 1] == '/' ) // recursively return a temporary file path
                return win_is_writable( $path . uniqid( mt_rand() ) . '.tmp');
            else if ( is_dir( $path ) )
                return win_is_writable( $path . '/' . uniqid( mt_rand() ) . '.tmp' );

            // check tmp file for read/write capabilities
            $should_delete_tmp_file = !file_exists( $path );
            $f = @fopen( $path, 'a' );
            if ( $f === false )
                return false;

            fclose( $f );

            if ( $should_delete_tmp_file )
                unlink( $path );

            return true;
        }
    }
?>

</body>

</html>
