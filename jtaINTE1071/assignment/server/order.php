<?php 
include('rsa.php');
include('des.php');
?>
<html>
    <body>
        <h2>Order Confirmation</h2>
        <?php 
        $ma = $_POST['multA']; 
        $mb = $_POST['multB'];
        $mc = $_POST['multC'];
        $ta = $_POST['hiddenA']; 
        $tb = $_POST['hiddenB']; 
        $tc = $_POST['hiddenC']; 
        $qt = $_POST['hiddenTot']; 
        $pt = $_POST['hiddenTP'];
        $des = $_POST['deskey']; 
        $cred = $_POST['cc']; 
        $user = $_POST['client']; 

        $privateKey = get_rsa_privatekey('private.key');
        $dma = rsa_decryption($ma, $privateKey); 
        $dta = rsa_decryption($ta, $privateKey); 
        $privateKey = get_rsa_privatekey('private.key');
        $dmb = rsa_decryption($mb, $privateKey); 
        $dtb = rsa_decryption($tb, $privateKey); 
        $privateKey = get_rsa_privatekey('private.key');
        $dmc = rsa_decryption($mc, $privateKey); 
        $dtc = rsa_decryption($tc, $privateKey); 
        $privateKey = get_rsa_privatekey('private.key');
        $dqt = rsa_decryption($qt, $privateKey); 
        $dpt = rsa_decryption($pt, $privateKey); 
        $privateKey = get_rsa_privatekey('private.key');
        $ddes = rsa_decryption($des, $privateKey); 
        $dcred = rsa_decryption($cred, $privateKey); 
             
        $recovered_message = php_des_decryption($ddes, $dcred);

        $file = fopen("../database/orders.txt", "a");
        fwrite($file, "Client: ".$user."\n");
        fwrite($file, "Ordered quantity information: \n"); 
        fwrite($file, "Product A: ".$dma." ($10 each)\n");
        fwrite($file, "Product B: ".$dmb." ($15 each)\n");
        fwrite($file, "Product C: ".$dmc." ($20 each)\n");
        fwrite($file, "Total Price: ".$dpt."\n");
        fwrite($file, "Credit Card Number: ".$recovered_message);
        fwrite($file, "\n\n--------------------------------\n");
        fclose($file);

        // PHP des decryption API (in des.php)
        ?>
        <table style="width:25%">
			<tr>
				<th>Products</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Subtotal</th>
			</tr>
			<tr>
				<td><center>Product A</center></td>
				<td><center>10</center></td>
				<td><center><?php echo $dma; ?></center></td>
				<td><center><?php echo $dta; ?></center></td>
			</tr>
			<tr>
				<td><center>Product B</center></td>
				<td><center>15</center></td>
				<td><center><?php echo $dmb; ?></center></td>
				<td><center><?php echo $dtb; ?></center></td>
			</tr>
			<tr>
				<td><center>Product C</center></td>
				<td><center>20</center></td>
				<td><center><?php echo $dmc; ?></center></td>
				<td><center><?php echo $dtc; ?></center></td>
			</tr>
			<tr>
				<td></td>
				<td><center>Total</center></td>
				<td><center><?php echo $dqt; ?></center></td>
				<td><center><?php echo $dpt; ?></center></td>
            </tr>
        </table>
        <p>Recovered encrypted DES key: <?php echo $des; ?></p>
        <p>Recovered DES key: <?php echo $ddes; ?></p>
        <p>Received encrypted credit card number: <?php echo $dcred; ?></p> 
        <p>Received credit card number: <?php echo $recovered_message; ?></p>
    </body>
</html>