<html>
    <body>
        <br/><br/>

        <?php
            //open a file name "test.txt"
            $file = fopen("database.txt", "a"); //"w"=overwrite
            $anything = $_POST['entered'];
            //lwrite into thte users.txt file
            fwrite($file, $anything . "\n");
            //close the file
            fclose($file);
        ?>
    </body>
</html>