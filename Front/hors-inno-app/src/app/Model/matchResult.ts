export interface ImatchResult {
    /**
     * id du match
     */
   match_id?: string;

    /**
     * id du pays
     */
    country_id?: string;

    /**
     * nom du pays
     */
    country_name?: string;

    /**
     * id de la league
     */
    league_id?: string;

    /**
     * nom de la league
     */
    league_name?: string;

    /**
     * date du match
     */
    match_date?: string;

    /**
     * status du match
     */
    match_status?: string;

    /**
     * heure du match
     */
    match_time?: string;

    /**
     * nom de la home team
     */
    match_hometeam_name?: string;

    /**
     * nombre de but de la home team
     */
    match_hometeam_score?: string;

    /**
     * nom de la away team
     */
    match_awayteam_name?: string;

    /**
     * nombre de but de la away team
     */
    match_awayteam_score?: string;

    /**
     * nombre de but de la home team durant 1er MiTemps
     */
    match_hometeam_halftime_score?: string;

    /**
     * nombre de but de la away team durant 1er MiTemps
     */
    match_awayteam_halftime_score?: string;

    /**
     * match live
     */
    match_live?: string;
}