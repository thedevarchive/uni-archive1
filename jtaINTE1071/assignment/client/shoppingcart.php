<?php
	session_start();
	if(!isset($_SESSION['login'])){
        header('Location: ../server/logout.php');
    }
    $user = $_SESSION['uname']; 
	echo "Hi! ".$user."<br/><br/>";
?>

<html>
	<head> 
		<script type="text/javascript" src="des.js"></script>
        <script type="text/javascript" src="js/rsa.js"></script>
        <script type="text/javascript">	
                    function RSA_encryption(){
                        var mult = document.getElementById("multA").value;
                        var mult1 = document.getElementById("multB").value; 
                        var mult2 = document.getElementById("multC").value; 
                        var result = document.getElementById("hiddenA").value; 
                        var result1 = document.getElementById("hiddenB").value; 
                        var result2 = document.getElementById("hiddenC").value; 
                        var tot = document.getElementById("hiddenTot").value; 
                        var totp = document.getElementById("hiddenTP").value; 
                        var desk = document.getElementById("deskey").value; 
						var ccnum = document.getElementById("cc").value;
						
						var encrypted = javascript_des_encryption(desk, ccnum);

                        var pubilc_key = "-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzdxaei6bt/xIAhYsdFdW62CGTpRX+GXoZkzqvbf5oOxw4wKENjFX7LsqZXxdFfoRxEwH90zZHLHgsNFzXe3JqiRabIDcNZmKS2F0A7+Mwrx6K2fZ5b7E2fSLFbC7FsvL22mN0KNAp35tdADpl4lKqNFuF7NT22ZBp/X3ncod8cDvMb9tl0hiQ1hJv0H8My/31w+F+Cdat/9Ja5d1ztOOYIx1mZ2FD2m2M33/BgGY/BusUKqSk9W91Eh99+tHS5oTvE8CI8g7pvhQteqmVgBbJOa73eQhZfOQJ0aWQ5m2i0NUPcmwvGDzURXTKW+72UKDz671bE7YAch2H+U7UQeawwIDAQAB-----END PUBLIC KEY-----";
                        // Encrypt with the public key...
                        var encrypt = new JSEncrypt();
                        encrypt.setPublicKey(pubilc_key);
                        var emult = encrypt.encrypt(mult);
                        var emult1 = encrypt.encrypt(mult1);
                        var emult2 = encrypt.encrypt(mult2);
                        var eresult = encrypt.encrypt(result);
                        var eresult1 = encrypt.encrypt(result1);
                        var eresult2 = encrypt.encrypt(result2);
                        var etot = encrypt.encrypt(tot);
                        var etotp = encrypt.encrypt(totp);
                        var edesk = encrypt.encrypt(desk); 
                        var eccn = encrypt.encrypt(encrypted); 
                      
                        document.getElementById("multA").value = emult;
                        document.getElementById("multB").value = emult1; 
                        document.getElementById("multC").value = emult2; 
                        document.getElementById("hiddenA").value = eresult; 
                        document.getElementById("hiddenB").value = eresult1; 
                        document.getElementById("hiddenC").value = eresult2; 
                        document.getElementById("hiddenTot").value = etot; 
                        document.getElementById("hiddenTP").value = etotp; 
                        document.getElementById("deskey").value = edesk; 
                        document.getElementById("cc").value = eccn; 
                    }
            
            
                
                    
			function displayA() {
				//get user input
				var price = 10; 
				var mult = document.getElementById('multA').value; 
				var x = price * mult; 
				// display result
				document.getElementById("resultA").innerHTML = x; 
			}
			function displayB() {
				//get user input
				var price = 15; 
				var mult = document.getElementById('multB').value; 
				var x = price * mult;
				
				// display result
				document.getElementById("resultB").innerHTML = x; 
			}
			function displayC() {
				//get user input
				var price = 20; 
				var mult = document.getElementById('multC').value; 
				var x = price * mult;

				// display result
				document.getElementById("resultC").innerHTML = x; 
			}
			function total() {
				var mult = document.getElementById('multA').value; 
				var mult1 = document.getElementById('multB').value;
				var mult2 = document.getElementById('multC').value;
				var tot = mult * 1 + mult1 * 1 + mult2 * 1; 

				document.getElementById("total").innerHTML = tot;
			}
			function payment(){
				var tot = document.getElementById('multA').value; 
				var tot1 = document.getElementById('multB').value;
				var tot2 = document.getElementById('multC').value; 
				var sum = tot * 10 + tot1 * 15 + tot2 * 20; 

				document.getElementById("totalPrice").innerHTML = sum; 
			}
			function processAll()
			{
				document.getElementById("hiddenA").value = (document.getElementById("resultA").innerHTML);
				document.getElementById("hiddenB").value = (document.getElementById("resultB").innerHTML);
				document.getElementById("hiddenC").value = (document.getElementById("resultC").innerHTML);
				document.getElementById("hiddenTot").value = (document.getElementById("total").innerHTML);
				document.getElementById("hiddenTP").value = (document.getElementById("totalPrice").innerHTML);
			}
			function updateAll()
			{
				displayA(); 
				displayB(); 
				displayC();
				total(); 
				payment(); 
				processAll();
			}
		</script>
	</head>

    <body>
    <form action="../server/logout.php" method="POST">
    <button type="submit">Logout</button>
    </form>
	<FORM ACTION="../server/order.php" method="POST">
		<table style="width:25%">
			<tr>
				<th>Products</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Subtotal</th>
			</tr>
			<tr>
				<td>Product A</td>
				<td>$10</td>
				<td><input id="multA" name="multA" onkeyup="updateAll()" value="0"></td>
				<td><input type="hidden" name="hiddenA" id="hiddenA" value="0"/><center><p id="resultA">0</p></center></td>
			</tr>
			<tr>
				<td>Product B</td>
				<td>$15</td>
				<td><input id="multB" name="multB" onkeyup="updateAll()" value="0"></td>
				<td><input type="hidden" name="hiddenB" id="hiddenB" value="0"/><center><p id="resultB">0</p></center></td>
			</tr>
			<tr>
				<td>Product C</td>
				<td>$20</td>
				<td><input id="multC" name="multC" onkeyup="updateAll()" value="0"></td>
				<td><input type="hidden" name="hiddenC" id="hiddenC" value="0"/><center><p id="resultC">0</p></center></td>
			</tr>
			<tr>
				<td></td>
				<td>Total</td>
				<td><input type="hidden" name="hiddenTot" id="hiddenTot" value="0"/><center><p id="total">0</p></center></td>
				<td><input type="hidden" name="hiddenTP" id="hiddenTP" value="0"/><center><p id="totalPrice">0</p></center></td>
            </tr>
            <tr>
                <td>Your DES key</td>
                <td><input type="text" id="deskey" name="deskey"></td>
            </tr>
            <tr>
                <td>Credit Card Number</td>
                <td><input id="cc" name="cc"></td>
            </tr>
			<tr>
				<td></td>
				<td></td>
                <td><input type="hidden" id="client" name="client" value="<?php echo $user; ?>"></td>
				<td><button type="submit" onclick="RSA_encryption()">Submit</button></td>
            </tr>
        </table>
	</FORM>
	</body>
</html>