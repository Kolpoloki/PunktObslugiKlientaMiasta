package zadanie.uslugi;

import zadanie.model.Sprawa;

public interface Wnioski {
    void dodajSprawe(Sprawa sprawa);
    void przypiszDzial(Sprawa sprawa,String dzial);
    void sprawdzPostep(Sprawa sprawa);
}
