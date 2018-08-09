public static synchronized void Sonido(final String url)
{
public void run()
{
  try{
        Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(
              Main.class.getResourceAsStream("C:\Users\Juan Fco\Documents\My Games\Sid Meier's Civilization 5\MODS\(Dragon Age Mod Project) The Dalish (v 7)\Art\Units\Keeper\Sounds\HurtFVoxA-004.wav" + url));
            clip.open(inputStream);
            clip.start();
  }
  catch (Exception e) {
    System.err.println(e.GetMessage());
  }
}
.start()
}
