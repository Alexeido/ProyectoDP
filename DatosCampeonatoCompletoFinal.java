public class DatosCampeonatoCompletoFinal
{
    
    public DatosCampeonatoCompletoFinal(Organizacion organizacion)
    {
        System.out.println("*********************************************************************************************************");
        System.out.println("*****************ESTA SIMULACIÓN CONCLUYE NORMALMENTE COMPLETÁNDOSE TODAS LAS CARRERAS*******************");
        System.out.println("*********************************************************************************************************\n");
        
        initData(organizacion);
    }
    
     private void initData(Organizacion organizacion)
    {
        //constructor de etapas pide ( String nombre, double dificultad, double distancia)
        Etapa etapa1 = new Etapa("sencilla larga", EtapaDificultad.SENCILLA,EtapaDistancia.LARGA);
        Etapa etapa2 = new Etapa("compleja corta", EtapaDificultad.COMPLEJA,EtapaDistancia.CORTA);
        Etapa etapa3 = new Etapa("normal intermedia", EtapaDificultad.NORMAL,EtapaDistancia.INTERMEDIA);
        Etapa etapa4 = new Etapa("sencilla intermedia", EtapaDificultad.SENCILLA, EtapaDistancia.INTERMEDIA);
        Etapa etapa5 = new Etapa("compleja intermedia", EtapaDificultad.COMPLEJA, EtapaDistancia.INTERMEDIA);
        Etapa etapa6 = new Etapa("normal larga", EtapaDificultad.NORMAL, EtapaDistancia.LARGA);
        organizacion.anadirEtapa(etapa1);
        organizacion.anadirEtapa(etapa2);
        organizacion.anadirEtapa(etapa3);
        organizacion.anadirEtapa(etapa4);
        organizacion.anadirEtapa(etapa5);
        organizacion.anadirEtapa(etapa6);
        

        //constructor de equipos pide (String nombre, comparador de ciclistas y si orden ascendente o descendente, comparador de bicicletas y si orden ascendente o descendente)
        Equipo movistarWomen = new Equipo("Movistar Women", new HabilidadComparatorAsc(), new PesoComparatorAsc()); //ciclistas comparados ascendentemente por habilidad (si iguales por nombre), bicicletas comparadas ascendentemente por peso (si iguales por nombre));
        Equipo dSMWomen= new Equipo("DSM Women", new EnergiaComparatorAsc(), new PesoComparatorAsc()); //ciclistas comparados ascendentemente por energía (si iguales por nombre), bicicletas comparadas ascendentemente por peso (si iguales por nombre)););
        Equipo trekSegafredoWomen = new Equipo("Trek Segafredo Women",new HabilidadComparatorDesc(),new PesoComparatorAsc()); //ciclistas comparados descendentemente por habilidad (si iguales por nombre), bicicletas comparadas descendentemente por peso (si iguales por nombre)););
        
        organizacion.anadirEquipo(movistarWomen);
        organizacion.anadirEquipo(trekSegafredoWomen);
        organizacion.anadirEquipo(dSMWomen);
        
        //constructor de bicicletas pide ( String nombre, Peso peso)
        //constructor de bicicletas rápidas pide ( String nombre, Peso peso, double velocidad extra)
        dSMWomen.addBicicleta(new BicicletaRapida("SCOTT CONTESSA ADDICT eRIDE 15",BicicletaPeso.LIGERA, 0.3)); 
        dSMWomen.addBicicleta(new BicicletaPrototipo("SCOTT CONTESSA ADDICT 15",BicicletaPeso.NORMAL));
        dSMWomen.addBicicleta(new Bicicleta("SCOTT CONTESSA ADDICT RC 15",BicicletaPeso.PESADA));
        //constructor de ciclistas pide (String nombre , Habilidad habilidad , double energia, Equipo equipo)
        dSMWomen.addCiclista(new CiclistaNovato("WIEBES",  CiclistaHabilidad.NORMAL, 1190, dSMWomen));
        dSMWomen.addCiclista(new CiclistaEstrella("LIPPERT", CiclistaHabilidad.NORMAL, 1160, dSMWomen));
        dSMWomen.addCiclista(new CiclistaExperimentado("LABOUS", CiclistaHabilidad.BUENA, 1150, dSMWomen));

        //constructor de bicicletas pide ( String nombre, Peso peso)
        //constructor de bicicletas rápidas pide ( String nombre, Peso peso, double velocidad extra)
        trekSegafredoWomen.addBicicleta(new Bicicleta("TREK Madone SLR 9 eTap Gen 7",BicicletaPeso.LIGERA));
        trekSegafredoWomen.addBicicleta(new BicicletaRapida("TREK Emonda SLR 9 eTap",BicicletaPeso.NORMAL, 0.5));
        trekSegafredoWomen.addBicicleta(new BicicletaPrototipo("TREK Domane SLR 9 eTap Gen 4",BicicletaPeso.PESADA));
        //constructor de ciclistas pide (String nombre , Habilidad habilidad , double energia, Equipo equipo)
        trekSegafredoWomen.addCiclista(new CiclistaEstrella("BALSAMO", CiclistaHabilidad.NORMAL,1180, trekSegafredoWomen));
        trekSegafredoWomen.addCiclista(new CiclistaExperimentado("LONGO-BORGHINI", CiclistaHabilidad.NORMAL,1175, trekSegafredoWomen));
        trekSegafredoWomen.addCiclista(new CiclistaNovato("CORDON-RAGOT", CiclistaHabilidad.BUENA, 1120, trekSegafredoWomen));
        
        //constructor de bicicletas pide ( String nombre, Peso peso)
        //constructor de bicicletas rápidas pide ( String nombre, Peso peso, double velocidad extra)
        movistarWomen.addBicicleta(new BicicletaRapida("CANYON Ultimate CFR eTap",BicicletaPeso.LIGERA, 0.4));
        movistarWomen.addBicicleta(new Bicicleta("CANYON Aeroad CF SLX 8 Disc Di2",BicicletaPeso.NORMAL));
        movistarWomen.addBicicleta(new BicicletaPrototipo("CANYON Endurace CF SLX 9 Di2",BicicletaPeso.PESADA));
        //constructor de ciclistas pide (String nombre , Habilidad habilidad , double energia, Equipo equipo)
        movistarWomen.addCiclista(new CiclistaEstrella("VAN VLEUTEN", CiclistaHabilidad.NORMAL,1200, movistarWomen));
        movistarWomen.addCiclista(new CiclistaExperimentado("NORSGAARD", CiclistaHabilidad.NORMAL,1145, movistarWomen));
        movistarWomen.addCiclista(new CiclistaNovato("SIERRA", CiclistaHabilidad.BUENA, 1130, movistarWomen));   

    }

}