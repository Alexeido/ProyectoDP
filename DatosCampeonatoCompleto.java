public class DatosCampeonatoCompleto
{
    
    public DatosCampeonatoCompleto(Organizacion organizacion)
    {
        System.out.println("*********************************************************************************************************");
        System.out.println("*****************ESTA SIMULACIÓN CONCLUYE NORMALMENTE COMPLETÁNDOSE TODAS LAS CARRERAS*******************");
        System.out.println("*********************************************************************************************************\n");
        
        initData(organizacion);
    }
    
     private void initData(Organizacion organizacion)
    {
        //constructor de etapas pide ( String nombre, double dificultad, double distancia)
        Etapa etapa1 = new Etapa("sencilla larga", 0.9, 200);
        Etapa etapa2 = new Etapa("compleja corta", 1.1, 150);
        Etapa etapa3 = new Etapa("normal intermedia", 1.0, 175);
        Etapa etapa4 = new Etapa("sencilla intermedia", 0.9, 175);
        Etapa etapa5 = new Etapa("compleja intermedia", 1.1, 175);
        Etapa etapa6 = new Etapa("normal larga", 1.0, 200);
        organizacion.anadirEtapa(etapa1);
        organizacion.anadirEtapa(etapa2);
        organizacion.anadirEtapa(etapa3);
        organizacion.anadirEtapa(etapa4);
        organizacion.anadirEtapa(etapa5);
        organizacion.anadirEtapa(etapa6);
        

        //constructor de equipos pide (String nombre, comparador de ciclistas y si orden ascendente o descendente, comparador de bicicletas y si orden ascendente o descendente)
        Equipo movistarWomen = new Equipo("Movistar Women", 'H', 'P');//ciclistas comparados ascendentemente por habilidad (si iguales por nombre), bicicletas comparadas ascendentemente por peso (si iguales por nombre));
        Equipo dSMWomen= new Equipo("DSM Women", 'E', 'P'); //ciclistas comparados ascendentemente por energía (si iguales por nombre), bicicletas comparadas ascendentemente por peso (si iguales por nombre)););
        Equipo trekSegafredoWomen = new Equipo("Trek Segafredo Women",'H','P'); //ciclistas comparados descendentemente por habilidad (si iguales por nombre), bicicletas comparadas descendentemente por peso (si iguales por nombre)););
        
        organizacion.anadirEquipo(movistarWomen);
        organizacion.anadirEquipo(trekSegafredoWomen);
        organizacion.anadirEquipo(dSMWomen);
        
		//constructor de bicicletas pide ( String nombre, double peso)
        dSMWomen.addbicileta(new Bicicleta("SCOTT CONTESSA ADDICT eRIDE 15",7.4)); 
        dSMWomen.addbicileta(new Bicicleta("SCOTT CONTESSA ADDICT 15",7.6));
        dSMWomen.addbicileta(new Bicicleta("SCOTT CONTESSA ADDICT RC 15",7.8));
		//constructor de ciclistas pide (String nombre , double habilidad , double energia, Equipo equipo)
        dSMWomen.addCiclista(new Ciclista("WIEBES",  4.97, 1190,dSMWomen));
        dSMWomen.addCiclista(new Ciclista("LIPPERT", 5.0, 1160,dSMWomen));
        dSMWomen.addCiclista(new Ciclista("LABOUS", 5.01, 1150,dSMWomen));

        //constructor de bicicletas pide ( String nombre, double peso)  
        trekSegafredoWomen.addbicileta(new Bicicleta("TREK Madone SLR 9 eTap Gen 7",7.35));
        trekSegafredoWomen.addbicileta(new Bicicleta("TREK Emonda SLR 9 eTap",7.65));
        trekSegafredoWomen.addbicileta(new Bicicleta("TREK Domane SLR 9 eTap Gen 4",7.85));
        //constructor de ciclistas pide (String nombre , double habilidad , double energia, Equipo equipo)
        trekSegafredoWomen.addCiclista(new Ciclista("BALSAMO", 4.98,1180,trekSegafredoWomen));
        trekSegafredoWomen.addCiclista(new Ciclista("LONGO-BORGHINI", 4.99,1175,trekSegafredoWomen));
        trekSegafredoWomen.addCiclista(new Ciclista("CORDON-RAGOT", 5.04, 1120,trekSegafredoWomen));
        
        //constructor de bicicletas pide ( String nombre, double peso)
        movistarWomen.addbicileta(new Bicicleta("CANYON Ultimate CFR eTap",7.45));
        movistarWomen.addbicileta(new Bicicleta("CANYON Aeroad CF SLX 8 Disc Di2",7.5));
        movistarWomen.addbicileta(new Bicicleta("CANYON Endurace CF SLX 9 Di2",7.75));
        //constructor de ciclistas pide (String nombre , double habilidad , double energia, Equipo equipo)
        movistarWomen.addCiclista(new Ciclista("VAN VLEUTEN", 4.96,1200,movistarWomen));
        movistarWomen.addCiclista(new Ciclista("NORSGAARD", 5.02,1145,movistarWomen));
        movistarWomen.addCiclista(new Ciclista("SIERRA", 5.03, 1130,movistarWomen));    

    }

}