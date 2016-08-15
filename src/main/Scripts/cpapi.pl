use cPanel::PublicAPI ();
use JSON::PP;
use Data::Dumper;

my $username = 'interstellarcom';
my $cp = cPanel::PublicAPI->new('ssl_verify_mode' => '0', 'ip' => '127.0.0.1:2087', 'debug' => '1');
my $addonDomains = $cp->cpanel_api2_request('listaddondomains',
        {
            'module' => 'AddonDomain',
            'func' => 'listaddondomains',
            'user' => $username,
            'format' => 'json',
            }
        );

my $subDomains = $cp->cpanel_api2_request('listsubdomains',
        {
            'module' => 'SubDomain',
            'func' => 'listsubdomains',
            'user' => $username,
            'format' => 'json',
            }
        );
#my $json = decode_json($cp);
#say $json;
#print "$cp\n";
#print Dumper $cp;
print Dumper $addonDomains;
print Dumper $subDomains;
