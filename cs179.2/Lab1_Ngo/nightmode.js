var nightModeActive = false; 

function nightMode()
{
  if(nightModeActive === false)
  {
      document.body.style.background = 'black';
      document.body.style.color = 'white'; 
      nightModeActive = true; 
  }
  else
  {
      document.body.style.background = 'white';
      document.body.style.color = 'black';
      nightModeActive = false; 
  }
}