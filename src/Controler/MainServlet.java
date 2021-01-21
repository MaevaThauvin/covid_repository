package Controler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ManageCas;
import exception.NonExistentCasException;
import modele.Admin;
import modele.Cas;
import modele.TestPcr;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String VUE_INDEX="index.jsp";
	private String VUE_GESTION="gestion.jsp";
	private String VUE_AJOUT_CAS="ajoutCas.jsp";
	private String VUE_AJOUT_TEST="ajoutTest.jsp";
	private String VUE_TEST_DETAIL="detailTestPCR.jsp";
	private String ATT_ACTION="action";
	private String ATT_LOGIN="login";
	private String ATT_PWD="pwd";       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("action")!=null) {
			String action = request.getParameter("action");
			switch (action) {
				case "detailTestPCR" :
					request.setAttribute("listCas", ManageCas.getListCas());
					int id_cas = Integer.parseInt(request.getParameter("id_cas"));
					request.setAttribute("cas", ManageCas.getCasByID(id_cas));
					request.setAttribute("listTest", ManageCas.getListTestById(id_cas));
					request.getRequestDispatcher(VUE_TEST_DETAIL).forward(request, response);
					break;
			}
		}
		else
			request.getRequestDispatcher(VUE_INDEX).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter(ATT_ACTION)!= null) {
			String action = request.getParameter(ATT_ACTION);
			switch (action) {
				case "connecter":
					if (request.getParameter(ATT_LOGIN) != null && request.getParameter(ATT_PWD) != null) {
						String login = request.getParameter(ATT_LOGIN);
						String password = request.getParameter(ATT_PWD);
						Admin admin = new Admin(login, password);
						admin.setLogin(login);
						admin.setPassword(password);
						if (admin.ValdiationPassword() && admin.ValidationLogin()) {
							request.setAttribute("listCas", ManageCas.getListCas());
							request.getRequestDispatcher(VUE_GESTION).forward(request, response);
						}
						else
							request.getRequestDispatcher(VUE_INDEX).forward(request, response);
					}
					break;
				case "goToAjout":
					request.getRequestDispatcher(VUE_AJOUT_CAS).forward(request, response);
					break;
				case "goToGestion":
					request.setAttribute("listCas", ManageCas.getListCas());
					request.getRequestDispatcher(VUE_GESTION).forward(request, response);
					break;
				case "goToIndex":
					request.getRequestDispatcher(VUE_INDEX).forward(request, response);
					break;
				case "goToDetail":
					int id_cas = Integer.parseInt(request.getParameter("id_cas"));
					request.setAttribute("listTest", ManageCas.getListTestById(id_cas));
					request.setAttribute("cas", ManageCas.getCasByID(id_cas));
					request.getRequestDispatcher(VUE_TEST_DETAIL).forward(request, response);
					break;
				case "ajouter":
					if (request.getParameter("nomComplet") != null && request.getParameter("telephone") != null
					&& request.getParameter("adresse") != null && request.getParameter("codePostale")!=null) {
						String nom_complet= request.getParameter("nomComplet");
						String telephone = request.getParameter("telephone");
						String adresse = request.getParameter("adresse");
						String code_postale = request.getParameter("codePostale");
						Cas cas = new Cas(nom_complet, telephone, adresse, code_postale);
						try {
							if( cas.ValidationNomComplet() && cas.ValidationTelephone() 
									&& cas.ValidationAdresse() && cas.ValidationCodePostale()) {
								ManageCas.ajouterCas(cas);
								request.setAttribute("listCas", ManageCas.getListCas());
								request.getRequestDispatcher(VUE_GESTION).forward(request, response);
							}
							else {
								cas.ValidationNomComplet();
								cas.ValidationTelephone();
								cas.ValidationAdresse();
								cas.ValidationCodePostale();
								request.setAttribute("cas", cas);
								request.setAttribute("erreur_nomcomplet", cas.getErreurs().get("nomComplet"));
								request.setAttribute("erreur_code_postale", cas.getErreurs().get("code_postale"));
								request.setAttribute("erreur_adresse", cas.getErreurs().get("adresse"));
								request.setAttribute("erreur_etat", cas.getErreurs().get("etat"));
								request.setAttribute("erreur_telephone", cas.getErreurs().get("telephone"));
								request.getRequestDispatcher(VUE_AJOUT_CAS).forward(request, response);
							}
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NonExistentCasException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}				

					}					
					break;
				case "testPCR":
					int id_cas2 = Integer.parseInt(request.getParameter("id_cas"));
					request.setAttribute("cas", ManageCas.getCasByID(id_cas2));
					request.getRequestDispatcher(VUE_AJOUT_TEST).forward(request, response);
					break;
				case "ajoutTest":
					if(request.getParameter("id_cas")!= null && request.getParameter("jour") != null &&
							request.getParameter("mois")!=null && request.getParameter("annee") !=null
							&& request.getParameter("resultat") != null) {
						try {
							int id_cas3 = Integer.parseInt(request.getParameter("id_cas"));
							int jour = Integer.parseInt(request.getParameter("jour"));
							int mois = Integer.parseInt(request.getParameter("mois"));
							int annee = Integer.parseInt(request.getParameter("annee"));
							int resultat = Integer.parseInt(request.getParameter("resultat"));
							TestPcr testpcr = new TestPcr(jour, mois, annee, resultat);
							ManageCas.ajouterTestPcr(ManageCas.getCasByID(id_cas3), testpcr);
							request.setAttribute("listTest", ManageCas.getListTestById(id_cas3));
							request.setAttribute("cas", ManageCas.getCasByID(id_cas3));
							
							request.getRequestDispatcher(VUE_TEST_DETAIL).forward(request, response);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NonExistentCasException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}		
					}								
					break;
			}
		}
		if (request.getAttribute("goToIndex")!= null) {
			request.getRequestDispatcher(VUE_INDEX).forward(request, response);
		}

	}

}
