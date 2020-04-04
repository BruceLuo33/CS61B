# Lab5 Experience

This lab is super suitable for the understanding of Map. Below is my experience of it.

1. In the Plip.chooseAction() method, we do not need to build a for-loop for each rule;
2. Instead, each rule of the Plip Action should be a branch of else-if structure;
3. The Clorus class is similar to the Plip class, but the most important hint is that the energy of Clorus
  could be less than zero. Thus the Clorus creature will not fill in the whole field. 
4. In the enhanced for-loop, notice that the key.name() will be different with neighbor.get(key).name():
  - The key.name() will return TOP/BOTTOM/RIGHT/LEFT, which is defined in the Direction class;
  - While the neighbors.get(key).name() will return the value that given in the Test file. For instance, 
  it will return empty/impassible.

